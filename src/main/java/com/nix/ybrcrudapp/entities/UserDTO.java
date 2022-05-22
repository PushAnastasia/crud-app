package com.nix.ybrcrudapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@javax.persistence.Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
  private String name;
}
