package com.alife.anotherlife.ui.screen.registration.base.reducer

import androidx.compose.ui.text.input.TextFieldValue
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.core.chain.ChainHandler
import com.alife.domain.registration.core.entity.DefaultRegEntity
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase

interface BaseRegistrationReducer {

    suspend fun onInit()

    suspend fun onBackPress()

    fun onTextInput(textFieldValue: TextFieldValue)

    suspend fun onNextClick()


    abstract class Abstract(
        uiStore: UIStore<RegistrationState, RegistrationEffect>,
        private val chainValidator: BaseRegTextChain,
        private val validationRegReducer: BaseValidationRegReducer,
        private val readUseCase: BaseRegStageUseCase.Read<*>,
    ) : RegistrationReducer(uiStore), BaseRegistrationReducer {

        override suspend fun onNextClick() {
            chainValidator.handle(
                uiStore.getState().textWithErrorModel.textFieldValue.text
            ).onChainResult(validationRegReducer)
        }

        override suspend fun onInit() {
            if (getState().textWithErrorModel.getCurrentText().isNotEmpty()) return

            val nameRegEntity = readUseCase.readData().regEntity
            if (nameRegEntity is DefaultRegEntity.Success) {
                uiStore.setState {
                    copy(textWithErrorModel = textWithErrorModel.copyText(nameRegEntity.result))
                }
            }
        }

    }

    abstract class WithInputChain(
        uiStore: UIStore<RegistrationState, RegistrationEffect>,
        ChainValidator: BaseRegTextChain,
        validationRegReducer: BaseValidationRegReducer,
        readUseCase: BaseRegStageUseCase.Read<*>,
        private val inputTextChain: ChainHandler.Base<String, Boolean>
    ) : Abstract(uiStore, ChainValidator, validationRegReducer, readUseCase) {

        override fun onTextInput(textFieldValue: TextFieldValue) {
            if (inputTextChain.handle(textFieldValue.text)) {
                super.onTextInput(textFieldValue)
            }
        }
    }
}