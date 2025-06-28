package com.pengrad.telegrambot.model.business

data class BusinessBotRights(
    @get:JvmName("canReply") val canReply: Boolean,
    @get:JvmName("canReadMessages") val canReadMessages: Boolean,
    @get:JvmName("canDeleteSentMessages") val canDeleteSentMessages: Boolean,
    @get:JvmName("canDeleteAllMessages") val canDeleteAllMessages: Boolean,
    @get:JvmName("canEditName") val canEditName: Boolean,
    @get:JvmName("canEditBio") val canEditBio: Boolean,
    @get:JvmName("canEditProfilePhoto") val canEditProfilePhoto: Boolean,
    @get:JvmName("canEditUsername") val canEditUsername: Boolean,
    @get:JvmName("canChangeGiftSettings") val canChangeGiftSettings: Boolean,
    @get:JvmName("canViewGiftsAndStars") val canViewGiftsAndStars: Boolean,
    @get:JvmName("canConvertGiftsToStars") val canConvertGiftsToStars: Boolean,
    @get:JvmName("canTransferAndUpgradeGifts") val canTransferAndUpgradeGifts: Boolean,
    @get:JvmName("canTransferStars") val canTransferStars: Boolean,
    @get:JvmName("canManageStories") val canManageStories: Boolean,
) {

}