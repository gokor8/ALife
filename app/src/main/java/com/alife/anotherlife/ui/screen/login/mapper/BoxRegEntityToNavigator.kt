package com.alife.anotherlife.ui.screen.login.mapper

import com.alife.anotherlife.core.navigation.nav_navigator.BaseNavigator
import com.alife.anotherlife.ui.screen.registration.birthday.navigation.RegBirthdayNavigator
import com.alife.anotherlife.ui.screen.registration.email.navigation.RegEmailNavigator
import com.alife.anotherlife.ui.screen.registration.name.navigation.RegNameNavigator
import com.alife.anotherlife.ui.screen.registration.username.navigation.UsernameRegNavigator
import com.alife.core.mapper.Mapper
import com.alife.domain.registration.core.entity.BoxRegEntity
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity
import com.alife.domain.registration.usecase.email.save_read.entity.EmailRegEntity
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity
import javax.inject.Inject

class BoxRegEntityToNavigator @Inject constructor() : Mapper<BoxRegEntity, BaseNavigator> {

    override fun map(inputModel: BoxRegEntity): BaseNavigator {
        return when(inputModel) {
            is UsernameRegEntity -> UsernameRegNavigator()
            is BirthdayRegEntity -> RegBirthdayNavigator()
            is EmailRegEntity -> RegEmailNavigator()
            else -> RegNameNavigator()
            // in else -> is NameRegEntity too
        }
    }
}