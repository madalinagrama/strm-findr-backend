import axios from "axios";
import React from "react";
import { useState } from "react";

const UserPage = () => {
    const [users, setUsers] = useState([]);

    const fetchUser = async () => {
        const resp = await axios.get("http://localhost:8080/auth");

        setUsers(resp.data);
    };

    console.log(users);

    return (
        <div>
            <button onClick={fetchUser}>SEARCH</button>
            {users.map((user, index) => (
                <p key={index}>
                    {user.firstName},{user.lastName}
                </p>
            ))}
        </div>
    );
};

export default UserPage;
