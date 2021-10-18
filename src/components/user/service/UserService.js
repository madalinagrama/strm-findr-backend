import axios from "axios";
import authHeader from "../../auth/components/services/auth-header";

const API_URL = "http://localhost:8080";

export const getUser = (username) => {
    let auth = authHeader();
    return axios.get(`${API_URL}/profile/${username}`, {
        headers: auth
    });
}