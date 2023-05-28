package com.alife.anotherlife.ui.screen.main.finish_create_alife.base_mapper

import android.util.Log
import androidx.annotation.StringRes
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.FinishErrorContract
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.FinishLCEGenericError
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.LCEErrorNoFile
import com.alife.data.repository.main.create_alife.NoFileException
import java.lang.Exception
import javax.inject.Inject

interface BaseFinishExceptionMapper {
    fun map(
        errorContract: FinishErrorContract,
        exception: Exception
    ): LCEModel.Error
}

abstract class FinishExceptionMapper(
    @StringRes private val noFileTitle: Int,
    @StringRes private val noFileDescription: Int
) : BaseFinishExceptionMapper {

    override fun map(
        errorContract: FinishErrorContract,
        exception: Exception
    ): LCEModel.Error {
        Log.e("Aboba", "Some finish error $exception")

        return when (exception) {
            is NoFileException -> LCEErrorNoFile(noFileTitle, noFileDescription, errorContract)
            else -> FinishLCEGenericError(errorContract)
        }
    }
}