package com.alife.data.repository.main.profile

import com.alife.data.repository.main.finish_create_alife.mapper.BaseFileToMultipart
import com.alife.data.repository.main.finish_create_alife.mapper.FileMediaType
import com.alife.data.repository.main.profile.mapper.BaseProfileResponseToProfileEntity
import com.alife.data.repository.main.profile.mapper.BaseUriToTempFile
import com.alife.data.repository.main.profile.model.DidntLoadImageException
import com.alife.data.repository.main.profile.model.PhotoUriWrapper
import com.alife.data.repository.main.profile.model.RequestProfileSaveData
import com.alife.data.services.ProfileService
import com.alife.domain.main.profile.entity.BasePhotoUriWrapper
import com.alife.domain.main.profile.entity.ProfileInfoEntity
import com.alife.domain.main.profile.entity.ProfileMainInfoEntity
import com.alife.domain.main.profile.repository.BaseProfileRepository
import java.io.File
import java.io.IOException
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val profileService: ProfileService,
    private val profileResponseToProfileEntity: BaseProfileResponseToProfileEntity,
    private val profileUriWrapper: BaseUriToTempFile,
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
            ProfileInfoEntity(username, name, description, pictureUrl)
        }
    }

    override suspend fun saveData(profileData: ProfileMainInfoEntity) {
        val request = with(profileData) {
            RequestProfileSaveData(username, name, description)
        }

        profileService.saveUserData(request).takeIf { it.isSuccessful } ?: throw IOException()
    }

    override suspend fun saveProfileImage(photoUri: BasePhotoUriWrapper): File {
        val uri = (photoUri as PhotoUriWrapper).uri

        val photoFile = profileUriWrapper.map(uri)

        profileService.saveAvatar(fileToMultipart.map(photoFile, FileMediaType.Image())).takeIf {
            it.code() == 200
        } ?: throw DidntLoadImageException()

        return photoFile
    }
}