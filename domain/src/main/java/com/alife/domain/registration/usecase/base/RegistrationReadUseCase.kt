//package com.alife.domain.registration.usecase.base
//
//import com.alife.domain.core.mapper.ThrowableMapper
//import com.alife.domain.core.usecase.AbstractSafeUseCase
//import com.alife.domain.registration.core.entity.BoxerRegEntity
//import com.alife.domain.registration.repository.BaseRegistrationRepository
//import com.alife.domain.registration.usecase.name.BaseNameUseCase
//import com.alife.domain.registration.usecase.name.NameReadRegEntity
//import com.alife.domain.registration.usecase.name.addons.NameRegEntity
//import kotlinx.coroutines.CoroutineDispatcher
//
//abstract class RegistrationReadUseCase<M : BoxerRegEntity>(
//    private val readRegInputEntity: ReadRegInputEntity<String>,
//    private val registrationRepository: BaseRegistrationRepository,
//    dispatcher: CoroutineDispatcher,
//    exceptionMapper: ThrowableMapper<M>,
//) : AbstractSafeUseCase<M>(dispatcher, exceptionMapper) {
//
//    suspend fun read() = withSafe {
//        registrationRepository.readRegData(readRegInputEntity)
//    }
//}