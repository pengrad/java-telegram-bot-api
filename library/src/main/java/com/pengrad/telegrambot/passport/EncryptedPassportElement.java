package com.pengrad.telegrambot.passport;

import com.google.gson.Gson;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.passport.decrypt.Decrypt;
import com.pengrad.telegrambot.request.GetFile;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Stas Parshin
 * 30 July 2018
 */
public class EncryptedPassportElement implements Serializable {
    private final static long serialVersionUID = 0L;

    public enum Type {
        personal_details, passport, driver_license, identity_card, internal_passport, address, utility_bill,
        bank_statement, rental_agreement, passport_registration, temporary_registration, phone_number, email
    }

    private Type type;
    private String data;
    private String phone_number;
    private String email;
    private PassportFile[] files;
    private PassportFile front_side;
    private PassportFile reverse_side;
    private PassportFile selfie;
    private PassportFile[] translation;
    private String hash;

    public DecryptedData decryptData(Credentials credentials) throws Exception {
        Class<? extends DecryptedData> clazz = dataClass();
        if (clazz == null || data == null) return null;
        SecureValue secureValue = credentials.secureData().ofType(type);
        DataCredentials dataCredentials = secureValue.data();
        String dataStr = Decrypt.decryptData(data, dataCredentials.dataHash(), dataCredentials.secret());
        return new Gson().fromJson(dataStr, clazz);
    }

    public byte[] decryptFile(PassportFile passportFile, FileCredentials fileCredentials, TelegramBot bot) throws Exception {
        File file = bot.execute(new GetFile(passportFile.fileId())).file();
        byte[] fileData = bot.getFileContent(file);
        return decryptFile(fileData, fileCredentials);
    }

    public byte[] decryptFile(PassportFile passportFile, Credentials credentials, TelegramBot bot) throws Exception {
        FileCredentials fileCredentials = findFileCredentials(passportFile, credentials);
        if (fileCredentials == null) {
            throw new IllegalArgumentException("Don't have file credentials for " + passportFile);
        }
        return decryptFile(passportFile, fileCredentials, bot);
    }

    public byte[] decryptFile(byte[] fileData, FileCredentials fileCredentials) throws Exception {
        return Decrypt.decryptFile(fileData, fileCredentials.fileHash(), fileCredentials.secret());
    }

    private FileCredentials findFileCredentials(PassportFile passportFile, Credentials credentials) {
        SecureValue secureValue = credentials.secureData().ofType(type);
        if (passportFile.equals(front_side)) return secureValue.frontSide();
        if (passportFile.equals(reverse_side)) return secureValue.reverseSide();
        if (passportFile.equals(selfie)) return secureValue.selfie();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (passportFile.equals(files[i])) return secureValue.files()[i];
            }
        }
        if (translation != null) {
            for (int i = 0; i < translation.length; i++) {
                if (passportFile.equals(translation[i])) return secureValue.translation()[i];
            }
        }
        return null;
    }

    private Class<? extends DecryptedData> dataClass() {
        if (Type.personal_details == type) return PersonalDetails.class;
        if (Type.passport == type) return IdDocumentData.class;
        if (Type.internal_passport == type) return IdDocumentData.class;
        if (Type.driver_license == type) return IdDocumentData.class;
        if (Type.identity_card == type) return IdDocumentData.class;
        if (Type.address == type) return ResidentialAddress.class;
        return null;
    }

    public Type type() {
        return type;
    }

    public String data() {
        return data;
    }

    public String phoneNumber() {
        return phone_number;
    }

    public String email() {
        return email;
    }

    public PassportFile[] files() {
        return files;
    }

    public PassportFile frontSide() {
        return front_side;
    }

    public PassportFile reverseSide() {
        return reverse_side;
    }

    public PassportFile selfie() {
        return selfie;
    }

    public PassportFile[] translation() {
        return translation;
    }

    public String hash() {
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EncryptedPassportElement that = (EncryptedPassportElement) o;

        if (type != that.type) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (phone_number != null ? !phone_number.equals(that.phone_number) : that.phone_number != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(files, that.files)) return false;
        if (front_side != null ? !front_side.equals(that.front_side) : that.front_side != null) return false;
        if (reverse_side != null ? !reverse_side.equals(that.reverse_side) : that.reverse_side != null) return false;
        if (selfie != null ? !selfie.equals(that.selfie) : that.selfie != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(translation, that.translation)) return false;
        return hash != null ? hash.equals(that.hash) : that.hash == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (phone_number != null ? phone_number.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(files);
        result = 31 * result + (front_side != null ? front_side.hashCode() : 0);
        result = 31 * result + (reverse_side != null ? reverse_side.hashCode() : 0);
        result = 31 * result + (selfie != null ? selfie.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(translation);
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EncryptedPassportElement{" +
                "type=" + type +
                ", data='" + data + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", files=" + Arrays.toString(files) +
                ", front_side=" + front_side +
                ", reverse_side=" + reverse_side +
                ", selfie=" + selfie +
                ", translation=" + Arrays.toString(translation) +
                ", hash='" + hash + '\'' +
                '}';
    }
}
