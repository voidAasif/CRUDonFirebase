# CRUDonFirebase

This is a simple Spring Boot project demonstrating **CRUD operations** (Create, Read, Update, Delete) on **Firebase Realtime Database** using **Firebase Admin**.

## 🔧 Features

- Connects Spring Boot to Firebase Realtime Database
- Saves and retrieves `Student` objects in Firebase
- Supports basic CRUD operations:
  - Create student
  - Read student by ID
  - Update student data
  - Delete student

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/Orbisys/CRUDonFirebase/
│   │       ├── config/
│   │       │   └── InitFirebaseConfig.java
│   │       ├── model/
│   │       │   └── Student.java
│   │       ├── service/
│   │       │   └── StudentService.java
│   │       └── controller/
│   │           └── StudentController.java
│   └── resources/
│       └── firebase/
│           └── firebase.json  # Your Firebase service account key
```

## 🧪 Example Firebase Structure

```json
{
  "Student": {
    "1": {
      "studentId": 1,
      "name": "Aasif",
      "available": true
    },
    "2": {
      "studentId": 2,
      "name": "John",
      "available": false
    }
  }
}
```

## ⚙️ Setup

### Firebase Config

- Go to [Firebase Console](https://console.firebase.google.com/)
- Create a project
- Go to **Project Settings → Service Accounts → Generate new private key**
- Save it as `firebase.json` under `src/main/resources/firebase/`


## 🔗 API Endpoints

> Replace `localhost:8080` with your base URL.

| Method | Endpoint            | Description        |
|--------|---------------------|--------------------|
| POST   | `/api/create`       | Create a student   |
| GET    | `/api/read/{id}`    | Get student by ID  |
| PUT    | `/api/update/{id}`  | Update student     |
| DELETE | `/api/delete/{id}`  | Delete student     |

## 📦 Dependencies

- Spring Boot Web
- Firebase Admin - Realtime Database
- Lombok

## ❗ Notes

- Firebase uses a NoSQL JSON tree, not tables.
- The "table name" is the root node, in this case, `"Student"`.
- Data operations are asynchronous — proper handling is necessary (e.g., using `CompletableFuture`).

## 👨‍💻 Author

- **voidAasif**
- [Portfolio](https://voidaasif.github.io/aasif)
- [Github Profile](https://github.com/voidAasif)

---

Feel free to fork, modify, or extend this project.

