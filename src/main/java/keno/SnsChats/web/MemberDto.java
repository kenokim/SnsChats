package keno.SnsChats.web;

import lombok.Data;
@Data
public class MemberDto {
    private String name;
    private String email;
    private String token;


    public static MemberDto createDto(String name, String email, String token) {
        MemberDto dto = new MemberDto();
        dto.name = name;
        dto.email = email;
        dto.token = token;
        return dto;
    }
    public static MemberDto createMock() {
        MemberDto dto = new MemberDto();
        dto.name = "키노";
        dto.email = "keno@gmail.com";
        dto.token = "hello-access-token";
        return dto;
    }
}
