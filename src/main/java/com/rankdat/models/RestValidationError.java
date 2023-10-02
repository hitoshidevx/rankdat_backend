package com.rankdat.models;

public record RestValidationError (    
Integer code,
String field,
String message ) { }
