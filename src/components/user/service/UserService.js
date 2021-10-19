import axios from "axios";
import authHeader from "../../auth/components/services/auth-header";

const API_URL = process.env.REACT_APP_BASE_URL;

export const getUser = (username) => {
    let auth = authHeader();
    return axios.get(`${API_URL}/profile/${username}`, {
        mode: 'cors',
        headers: auth
    });
}