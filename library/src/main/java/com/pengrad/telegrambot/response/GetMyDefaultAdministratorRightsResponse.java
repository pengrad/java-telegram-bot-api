package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.ChatAdministratorRights;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class GetMyDefaultAdministratorRightsResponse extends BaseResponse {
    
    private ChatAdministratorRights result;

    public ChatAdministratorRights result() {
        return result;
    }
    
    @Override
    public String toString() {
        return "GetMyDefaultAdministratorRightsResponse{" +
                "result=" + result +
                '}';
    }

}
