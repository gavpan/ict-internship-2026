students = []

print("Hello! Welcome to the Student Information")

while True:
    name = input("Enter your name: ").strip()
    age = input("Enter your age: ").strip()
    grade = input("Enter your grade: ").strip()

    students.append([name, age, grade])
    again = input("Add another student? (yes/no): ")
    if again.lower() != "yes":
        break

print("Students")

for student in students:
    print("Name:", student[0])
    print("Age:", student[1])
    print("Grade:", student[2])

print("Program ended")