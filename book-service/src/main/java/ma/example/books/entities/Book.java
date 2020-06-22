package ma.example.books.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "BOOKS")
@ToString
public class Book {

	@Id
	@GeneratedValue
	private Long bookId;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "PAGES")
	private int pages;
	
}
