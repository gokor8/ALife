package com.alife.data.repository.main.profile

import com.alife.data.services.ProfileService
import com.alife.domain.main.profile.entity.ProfileInfoEntity
import com.alife.domain.main.profile.repository.BaseProfileRepository
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val profileService: ProfileService
) : BaseProfileRepository {

    override suspend fun getPostProfile(username: String): ProfileInfoEntity {
        return with(profileService.getPostProfile(username)) {
            ProfileInfoEntity(username, name, country, description, pictureUrl)
        }
//        return ProfileInfoEntity(
//            username,
//            "Grixailo",
//            "ARM",
//            "Рыдцарь",
//            "some url"
//        )
    }

    override suspend fun getUserInfo(): ProfileInfoEntity {
        return with(profileService.getUserInfo()) {
            ProfileInfoEntity(username, name, country, description, pictureUrl)
        }
    }
}