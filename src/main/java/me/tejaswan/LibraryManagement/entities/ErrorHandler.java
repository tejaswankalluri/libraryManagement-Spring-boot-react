package me.tejaswan.LibraryManagement.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorHandler {
    private HttpStatus Status;
    private String Message;
    private boolean Success = false;
    private String path;
}
