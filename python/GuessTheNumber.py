#!/usr/bin/env python 

import random
__author__ = "Marvin"

def generate_number():
    generated_number = random.randrange(1,20)
    return generated_number


def compare(user_guess,random_number):
    if (user_guess-random_number) != 0:
        return input_difference(user_guess,random_number)
    else:
        return same_number()


def input_difference(user_guess,random_number):
    difference = user_guess-random_number
    if difference <= -2:
        return "Your input is lower"
    elif difference == 1 or difference == -1:
        return("You are very close")
    else:
        return "Your input is higher"


def same_number():
    print("Exact Number found!")
    return False


random_number = generate_number()
guess_attempts = 1

while True:
    try:
        user_guess = int(input("Insert a number between 1-20: "))
        comparison = compare(user_guess,random_number)

        guess_attempts +=1
        if  comparison == False:
            break
        print(comparison)

        if guess_attempts == 6:
            print("You had 5 attempts. New Number has been generated!\n")
            random_number = generate_number()
    except ValueError:
        print("Integer only\n")