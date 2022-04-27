package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class PromoteChatMember extends BaseRequest<PromoteChatMember, BaseResponse> {

    public PromoteChatMember(Object chatId, long userId) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("user_id", userId);
    }

    public PromoteChatMember isAnonymous(boolean isAnonymous) {
        return add("is_anonymous", isAnonymous);
    }

    public PromoteChatMember canManageChat(boolean canManageChat) {
        return add("can_manage_chat", canManageChat);
    }

    public PromoteChatMember canChangeInfo(boolean canChangeInfo) {
        return add("can_change_info", canChangeInfo);
    }

    public PromoteChatMember canPostMessages(boolean canPostMessages) {
        return add("can_post_messages", canPostMessages);
    }

    public PromoteChatMember canEditMessages(boolean canEditMessages) {
        return add("can_edit_messages", canEditMessages);
    }

    public PromoteChatMember canDeleteMessages(boolean canDeleteMessages) {
        return add("can_delete_messages", canDeleteMessages);
    }

    /**
     * @deprecated Use canManageVideoChats(boolean canManageVideoChats) instead
     */
    public PromoteChatMember canManageVoiceChats(boolean canManageVoiceChats) {
        return add("can_manage_video_chats", canManageVoiceChats);
    }

    public PromoteChatMember canManageVideoChats(boolean canManageVideoChats) {
        return add("can_manage_video_chats", canManageVideoChats);
    }

    public PromoteChatMember canInviteUsers(boolean canInviteUsers) {
        return add("can_invite_users", canInviteUsers);
    }

    public PromoteChatMember canRestrictMembers(boolean canRestrictMembers) {
        return add("can_restrict_members", canRestrictMembers);
    }

    public PromoteChatMember canPinMessages(boolean canPinMessages) {
        return add("can_pin_messages", canPinMessages);
    }

    public PromoteChatMember canPromoteMembers(boolean canPromoteMembers) {
        return add("can_promote_members", canPromoteMembers);
    }
}
