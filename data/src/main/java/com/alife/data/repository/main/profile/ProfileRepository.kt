package com.alife.data.repository.main.profile

import androidx.core.net.toFile
import com.alife.data.repository.main.finish_create_alife.mapper.BaseFileToMultipart
import com.alife.data.repository.main.finish_create_alife.mapper.FileMediaType
import com.alife.data.repository.main.profile.mapper.BasePhotoUriWrapperToUri
import com.alife.data.repository.main.profile.mapper.BaseProfileResponseToProfileEntity
import com.alife.data.repository.main.profile.model.PhotoUriWrapper
import com.alife.data.repository.main.profile.model.RequestProfileSaveData
import com.alife.data.services.ProfileService
import com.alife.domain.core.MappingException
import com.alife.domain.main.profile.entity.BasePhotoUriWrapper
import com.alife.domain.main.profile.entity.ProfileInfoEntity
import com.alife.domain.main.profile.entity.ProfileMainInfoEntity
import com.alife.domain.main.profile.repository.BaseProfileRepository
import java.io.File
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val profileService: ProfileService,
    private val profileResponseToProfileEntity: BaseProfileResponseToProfileEntity,
    private val profileUriWrapper: BasePhotoUriWrapperToUri,
    private val fileToMultipart: BaseFileToMultipart
) : BaseProfileRepository {

    override suspend fun getPostProfile(username: String): ProfileInfoEntity {
        return profileResponseToProfileEntity.map(profileService.getPostProfile(username))
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

    override suspend fun getPhotoBytes(photoUri: BasePhotoUriWrapper): File {
        return profileUriWrapper.map(photoUri)
    }

    override suspend fun saveData(profileData: ProfileMainInfoEntity): ProfileInfoEntity {
        val request = with(profileData) {
            RequestProfileSaveData(username, name, description)
        }

        return profileResponseToProfileEntity.map(profileService.saveUserData(request))
    }

    override suspend fun saveProfileImage(photoUri: BasePhotoUriWrapper) {
        val photoFile = profileUriWrapper.map(photoUri)

        profileService.saveAvatar(fileToMultipart.map(photoFile, FileMediaType.Image()))
    }
}