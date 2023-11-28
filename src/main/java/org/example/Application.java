package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		NoteService noteService = new NoteService();

		Note noteToAdd = new Note();
		noteToAdd.setTitle("Test Title");
		noteToAdd.setContent("Test Content");
		Note addedNote = noteService.add(noteToAdd);

		System.out.println("All Notes after adding:");
		noteService.listAll().forEach(note -> System.out.println(note.getTitle() + ": " + note.getContent()));

		Long noteId = addedNote.getId();
		Note retrievedNote = noteService.getById(noteId);
		System.out.println("\nRetrieved Note:");
		System.out.println(retrievedNote.getTitle() + ": " + retrievedNote.getContent());

		retrievedNote.setTitle("Updated Title");
		retrievedNote.setContent("Updated Content");
		noteService.update(retrievedNote);
		System.out.println("\nAll Notes after updating:");
		noteService.listAll().forEach(note -> System.out.println(note.getTitle() + ": " + note.getContent()));

		noteService.deleteById(noteId);
		System.out.println("\nAll Notes after deletion:");
		noteService.listAll().forEach(note -> System.out.println(note.getTitle() + ": " + note.getContent()));
	}

}
