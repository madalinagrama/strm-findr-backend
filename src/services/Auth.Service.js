import axios from "axios";

const API_URL = "http://localhost:8080/api/auth/";

const AuthService = () => {
    const login = (username, password) => {
        return axios.post(API_URL + "login", {
            username,
            password,
        })
            .then(response => {
                if (response.data.token) {
                    localStorage.setItem("user", JSON.stringify(response.data));
                }
                return response
            });
    }

    const logout = () => {
        localStorage.removeItem("user");
    }

    const register = (username, email, password) => {
        return axios.post(API_URL + "register", {
            username,
            email,
            password,
        })
    }

    const getCurrentUser = () => {
        return JSON.parse(localStorage.getItem('user'));
    }

    const addUserToLocalStorage = (user) => {
        localStorage.setItem("user", JSON.stringify(user));
    }
}

export default AuthService;