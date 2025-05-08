package com.Orbisys.CRUDonFirebase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    private int studentId;
    private String name;
    private boolean available;
}

