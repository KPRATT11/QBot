package org.example.Exceptions

class InvalidCommandTypeException (commandLetter: String, message: String = "command type $commandLetter is not recognised") : Exception(message)