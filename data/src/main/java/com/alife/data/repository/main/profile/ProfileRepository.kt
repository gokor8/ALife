package com.alife.data.repository.main.profile

import android.content.Context
import com.alife.data.services.ProfileService
import com.alife.domain.core.MappingException
import com.alife.domain.main.profile.entity.BasePhotoUriWrapper
import com.alife.domain.main.profile.entity.ProfileInfoEntity
import com.alife.domain.main.profile.repository.BaseProfileRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    @ApplicationContext
    private val context: Context,
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

    override suspend fun getPhotoBytes(photoUriReader: BasePhotoUriWrapper): ByteArray {
        val photoUri = if(photoUriReader is PhotoUriWrapper) {
            photoUriReader.uri
        } else throw MappingException()

        return context.contentResolver.openInputStream(photoUri).use { imageStream ->
            imageStream?.readBytes()
        } ?: throw IOException()
    }
}