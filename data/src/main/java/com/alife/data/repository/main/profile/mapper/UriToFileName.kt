package com.alife.data.repository.main.profile.mapper

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import com.alife.core.mapper.Mapper
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.lang.Exception
import javax.inject.Inject

class UriExtensionReadException : Exception()

interface BaseUriToFileName : Mapper<Uri, String>

class UriToFileName @Inject constructor(
    @ApplicationContext
    private val context: Context
) : BaseUriToFileName {

    override fun map(uri: Uri): String {
        return if (uri.scheme.equals(ContentResolver.SCHEME_CONTENT)) {
            MimeTypeMap.getSingleton().getExtensionFromMimeType(
                context.contentResolver.getType(uri)
            ) ?: throw UriExtensionReadException()
        } else if (uri.path != null) {
            MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(File(uri.path)).toString());
        } else {
            throw UriExtensionReadException()
        }
    }
}