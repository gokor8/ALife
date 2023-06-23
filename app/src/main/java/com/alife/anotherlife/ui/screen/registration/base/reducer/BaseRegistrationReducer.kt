package com.alife.anotherlife.ui.screen.registration.base.reducer

import androidx.compose.ui.text.input.TextFieldValue
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import com.alife.core.chain.ChainHandler
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase
import com.alife.domain.registration.usecase.base.entity.BaseRegEntity

interface BaseRegistrationReducer {

    suspend fun onInit()

    suspend fun onBackPress()

    fun onTextInput(textFieldValue: TextFieldValue)

    suspend fun onNextClick()


    abstract class Abstract(
        uiStore: UIStore<RegistrationState, RegistrationEffect>,
        private val chainValidator: BaseRegTextChain,
        private val validationRegReducer: BaseValidationRegReducer,
        private val readUseCase: BaseRegStageUseCase.Read<BaseRegEntity>,
    ) : RegistrationReducerBase(uiStore), BaseRegistrationReducer {

        override suspend fun onNextClick() {
            chainValidator.handle(
                uiStore.getState().textErrorModel.textFieldValue.text
            ).onChainResult(validationRegReducer)
        }

        override suspend fun onInit() {
            if (getState().textErrorModel.getCurrentText().isNotEmpty()) return

            val nameRegEntity = readUseCase.readData()
            // Можно убрать дженерик
            // Перемапить в юай модель, и инкапсулировать в юай модель setState
            if (nameRegEntity is UseCaseResult.Success) {
                uiStore.setState {
                    copy(
                        textErrorModel = textErrorModel.copyText(nameRegEntity.model.text)
                    )
                }
            }
        }

    }

    abstract class WithInputChain(
        uiStore: UIStore<RegistrationState, RegistrationEffect>,
        ChainValidator: BaseRegTextChain,
        validationRegReducer: BaseValidationRegReducer,
        readUseCase: BaseRegStageUseCase.Read<BaseRegEntity>,
        private val inputTextChain: ChainHandler.Base<String, Boolean>,
    ) : Abstract(uiStore, ChainValidator, validationRegReducer, readUseCase) {

        override fun onTextInput(textFieldValue: TextFieldValue) {
            if (inputTextChain.handle(textFieldValue.text)) {
                super.onTextInput(textFieldValue)
            }
        }
    }
}