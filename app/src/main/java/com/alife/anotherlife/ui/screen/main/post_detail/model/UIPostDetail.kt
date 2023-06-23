package com.alife.anotherlife.ui.screen.main.post_detail.model

interface BaseUIPostDetail {
    val username: String
    val timestamp: String
    val avatar: String?
    val uiPostMedia: UIPostMedia

    class Empty(
        override val username: String = "",
        override val timestamp: String = "",
        override val avatar: String = "",
        override val uiPostMedia: UIPostMedia = UIPostMedia.Empty()
    ) : BaseUIPostDetail

    class UIPostDetail(
        override val username: String,
        override val timestamp: String,
        override val avatar: String? = "",
        override val uiPostMedia: UIPostMedia
    ) : BaseUIPostDetail
}