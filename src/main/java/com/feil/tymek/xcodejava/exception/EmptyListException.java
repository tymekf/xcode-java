package com.feil.tymek.xcodejava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NO_CONTENT, reason = "list of numbers cannot be empty")
public class EmptyListException extends Exception   {

}