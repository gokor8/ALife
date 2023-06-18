//package com.alife.data.repository.main.home.child.mapper
//
//import com.alife.data.repository.main.home.child.model.PostsResponse
//import com.alife.domain.main.home.child.base_entity.BadPostEntity
//import com.alife.domain.main.home.child.base_entity.ImagePostEntity
//import com.alife.domain.main.home.child.base_entity.PostsEntity
//import com.alife.domain.main.home.child.base_entity.VideoPostEntity
//import java.util.Date
//import javax.inject.Inject
//
//interface BasePostsResponseToPostsEntityMockImage {
//
//    fun map(
//        inputModel: PostsResponse,
//        avatarUrl: String,
//        firstUrl: String,
//        secondUrl: String
//    ): PostsEntity
//}
//
//class PostsResponseToPostsEntityMockImage @Inject constructor() :
//    BasePostsResponseToPostsEntityMockImage {
//
//    override fun map(
//        inputModel: PostsResponse,
//        avatarUrl: String,
//        firstUrl: String,
//        secondUrl: String
//    ) = PostsEntity(inputModel.results.map { postResponse ->
//        with(postResponse) {
//            when(postResponse) {
//                is ImagePostEntity -> ImagePostEntity(
//                    username, Date(creationDate), avatarUrl, firstUrl, secondUrl
//                )
//                isVideo() -> VideoPostEntity(
//                    username, Date(creationDate), avatarUrl, firstUrl
//                )
//                else -> BadPostEntity(
//                    postResponse.username,
//                    Date(postResponse.creationDate),
//                    avatarUrl
//                )
//            }
//        }
//    })
//}