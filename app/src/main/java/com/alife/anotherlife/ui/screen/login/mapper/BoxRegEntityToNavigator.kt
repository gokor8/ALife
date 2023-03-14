package com.alife.anotherlife.ui.screen.login.mapper

import com.alife.anotherlife.core.navigation.nav_navigator.BaseNavigator
import com.alife.anotherlife.ui.screen.registration.birthday.navigation.RegBirthdayNavigator
import com.alife.anotherlife.ui.screen.registration.email.navigation.RegEmailNavigator
import com.alife.anotherlife.ui.screen.registration.name.navigation.RegNameNavigator
import com.alife.anotherlife.ui.screen.registration.username.navigation.UsernameRegNavigator
import com.alife.core.mapper.Mapper
import com.alife.domain.registration.core.entity.BoxRegEntity
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase
import com.alife.domain.registration.usecase.base.entity.ReadBoxRegEntity
import com.alife.domain.registration.usecase.birthday.entity.BirthdayReadBoxEntity
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity
import com.alife.domain.registration.usecase.email.save_read.EmailReadRegEntity
import com.alife.domain.registration.usecase.email.save_read.entity.EmailReadBoxEntity
import com.alife.domain.registration.usecase.email.save_read.entity.EmailRegEntity
import com.alife.domain.registration.usecase.username.UsernameReadRegEntity
import com.alife.domain.registration.usecase.username.addons.UsernameReadBoxEntity
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity
import javax.inject.Inject

class BoxRegEntityToNavigator @Inject constructor() : Mapper<ReadBoxRegEntity<*>, BaseNavigator> {

    override fun map(inputModel: ReadBoxRegEntity<*>): BaseNavigator {
        return when (inputModel) {
            is UsernameReadBoxEntity -> UsernameRegNavigator()
            is BirthdayReadBoxEntity -> RegBirthdayNavigator()
            is EmailReadBoxEntity -> RegEmailNavigator()
            else -> RegNameNavigator()
            // in else -> is NameRegEntity too
        }
    }
}