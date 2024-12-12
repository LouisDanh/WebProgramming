package models;

import java.time.LocalDateTime;
import java.util.List;

public class Account {
private int id;
private Customer customer;
private String email;
private String password;
private boolean ban;
private int role;
private LocalDateTime createDate;
private List<Violate> violates;
}
