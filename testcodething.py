students = []

print("Hello! Welcome to the Student Information")

while True:
    print("")
    print("1. Add a new student")
    print("2. View all students")
    print("3. Search for a student")
    print("4. Update a student")
    print("5. Delete a student")
    print("6. Exit")
    choice = input("Enter your choice: ").strip()

    if choice == "1":
        sid = input("Enter Student ID: ").strip()
        if sid == "":
            print("Student ID cannot be empty")
            continue
        found = False
        for student in students:
            if student[0] == sid:
                found = True
        if found == True:
            print("That Student ID already exists")
            continue

        name = input("Enter your name: ").strip()
        if name == "":
            print("Name cannot be empty")
            continue

        age = input("Enter your age: ").strip()
        if age.isdigit() == False:
            print("Age must be a number")
            continue

        grade = input("Enter your grade: ").strip()
        if grade == "":
            print("Grade cannot be empty")
            continue

        section = input("Enter your section: ").strip()
        if section == "":
            print("Section cannot be empty")
            continue

        students.append([sid, name, age, grade, section])
        print("Student added!")

    elif choice == "2":
        if len(students) == 0:
            print("No students yet")
        else:
            print("Students")
            for student in students:
                print("")
                print("ID:", student[0])
                print("Name:", student[1])
                print("Age:", student[2])
                print("Grade:", student[3])
                print("Section:", student[4])

    elif choice == "3":
        sid = input("Enter Student ID to search: ").strip()
        found = False
        for student in students:
            if student[0] == sid:
                print("ID:", student[0])
                print("Name:", student[1])
                print("Age:", student[2])
                print("Grade:", student[3])
                print("Section:", student[4])
                found = True
        if found == False:
            print("Student not found")

    elif choice == "4":
        sid = input("Enter Student ID to update: ").strip()
        found = False
        for student in students:
            if student[0] == sid:
                found = True
                name = input("Enter new name: ").strip()
                if name == "":
                    print("Name cannot be empty")
                    break
                age = input("Enter new age: ").strip()
                if age.isdigit() == False:
                    print("Age must be a number")
                    break
                grade = input("Enter new grade: ").strip()
                if grade == "":
                    print("Grade cannot be empty")
                    break
                section = input("Enter new section: ").strip()
                if section == "":
                    print("Section cannot be empty")
                    break
                student[1] = name
                student[2] = age
                student[3] = grade
                student[4] = section
                print("Student updated!")
        if found == False:
            print("Student not found")

    elif choice == "5":
        sid = input("Enter Student ID to delete: ").strip()
        found = False
        for student in students:
            if student[0] == sid:
                found = True
                sure = input("Are you sure you want to delete? (yes/no): ")
                if sure.lower() == "yes":
                    students.remove(student)
                    print("Student deleted")
                else:
                    print("Delete cancelled")
                break
        if found == False:
            print("Student not found")

    elif choice == "6":
        print("Program ended")
        break

    else:
        print("Invalid choice, please pick 1 to 6")