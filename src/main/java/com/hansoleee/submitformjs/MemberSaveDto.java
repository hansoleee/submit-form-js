package com.hansoleee.submitformjs;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MemberSaveDto {

    @NotBlank
    private String name;
    @NotNull
    private Integer age;

    public Member toEntity() {
        return new Member(this.name, this.age);
    }
}