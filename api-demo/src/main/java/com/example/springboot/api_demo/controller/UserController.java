package com.example.springboot.api_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.springboot.api_demo.dto.user.UserRequestDto;
import com.example.springboot.api_demo.dto.user.UserResponseDto;
import com.example.springboot.api_demo.usecase.UserUsecase;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {
	@Autowired
	UserUsecase usecase;

	@GetMapping
	public ResponseEntity<List<UserResponseDto>> getAllUsers() {
		final List<UserResponseDto> users = this.usecase.findUserList();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
		final UserResponseDto user = this.usecase.findUserById(id);
		return ResponseEntity.ok(user);
	}

	@PostMapping
	public ResponseEntity<UserResponseDto> createUser(@RequestBody @Validated UserRequestDto dto) {
		final UserResponseDto user = this.usecase.addUser(dto);
		return ResponseEntity.ok(user);
	}

	@PatchMapping("/{id}/switchActive")
	public ResponseEntity<Boolean> updateUserActive(@PathVariable Long id) {
		final boolean isActive = this.usecase.switchUserActiveById(id);
		return ResponseEntity.ok(isActive);
	}

	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
		final boolean isActive = this.usecase.deleteUserById(id);
		return ResponseEntity.ok(isActive);
	}
}