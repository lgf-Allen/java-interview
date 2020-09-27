package com.allen.string;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * @author ligenfeng
 * @date 2020/9/26 10:15 下午
 * <p>
 * 468. 验证IP地址
 * 难度
 * 中等
 * <p>
 * 54
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
 * <p>
 * 如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；
 * 如果不是上述类型的 IP 地址，返回 "Neither" 。
 * IPv4 地址由十进制数和点来表示，每个地址包含 4 个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 * <p>
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
 * <p>
 * IPv6 地址由 8 组 16 进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 * <p>
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 * <p>
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 */
public class IPSolution {

    public static void main(String[] args) {
        IPSolution ipSolution = new IPSolution();
        System.out.println(ipSolution.validIPAddress("172.16.254.1"));
        System.out.println(ipSolution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(ipSolution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(ipSolution.validIPAddress("1e1.4.5.6"));
        System.out.println(ipSolution.validIPAddress("1.1.1.1."));
        System.out.println(ipSolution.validIPAddress("2001:0db8:85a3:033:0:8A2E:0370:7334"));
        System.out.println(ipSolution.validIPAddress("1.0.1."));
    }

    public String validIPAddress(String IP) {
        if (IP == null || IP.isEmpty()) {
            return "Neither";
        }
        if (IP.contains(".") && isIPv4(IP)) {
            return "IPv4";
        } else if (IP.contains(":") && isIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private boolean isIPv4(String IP) {
        String[] array = IP.split("\\.", -1);
        if (array.length != 4) {
            return false;
        }
        for (String subString : array) {
            // 1.0.1.
            if (subString == null || subString.isEmpty()
                    || (subString.length() != 1 && subString.startsWith("0") || subString.length() > 3)) {
                return false;
            }
            for (char ch : subString.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return false;
                }
            }
            int value = Integer.parseInt(subString);
            if (value < 0 || value > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isIPv6(String IP) {
        String[] array = IP.split(":", -1);
        if (array.length != 8) {
            return false;
        }
        for (String subString : array) {
            if (subString == null || subString.length() == 0 || subString.length() > 4) {
                return false;
            }
            // 判断每位是否符合16进制规则
            for (char ch : subString.toCharArray()) {
                if (!Character.isDigit(ch) && Character.toUpperCase(ch) > 'F') {
                    return false;
                }
            }
        }
        return true;
    }
}
