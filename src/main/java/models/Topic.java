package models;

import java.time.LocalDateTime;
import java.util.List;

public class Topic {
private int id;
private String title;
private String decription;
private LocalDateTime createDate;
private List<ProductTopic> products;
}
