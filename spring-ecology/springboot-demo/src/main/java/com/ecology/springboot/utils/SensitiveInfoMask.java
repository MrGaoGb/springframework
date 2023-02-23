package com.ecology.springboot.utils;

/**
 * @author Mr.Gao
 * @date 2023/2/23 18:28
 * @apiNote:敏感四要素信息掩码处理
 */
public class SensitiveInfoMask {

    /**
     * 敏感四要素信息掩码处理
     * 支持手机号、银行卡号
     *
     * @param content
     * @param leftReserve
     * @param rightReserve
     * @param masks
     * @return
     */
    public static String mask(String content, int leftReserve, int rightReserve, int masks) {
        int length = content.length();
        int maskLength = length - (leftReserve + rightReserve);
        if (maskLength <= 0) {
            return content;
        }

        StringBuilder mask = new StringBuilder(content.substring(0, leftReserve));
        for (int i = 0; i < masks; i++) {
            mask.append(" ****");
        }
        mask.append(" ");
        mask.append(content.substring(length - rightReserve));
        return mask.toString();
    }
}
