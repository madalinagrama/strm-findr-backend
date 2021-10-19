import React, { useState, useEffect } from "react";

import AuthService from "./services/auth.service";
import isEmail from "validator/es/lib/isEmail";

import classes from "./AuthForm.module.css";

const Register = () => {
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [message, setMessage] = useState("");
    const [successful, setSuccessful] = useState(false);

    const errorHandling = () => {
        const errors = [
            !username.length && "Username is required!",
            (username.length < 3 || username.length > 25) &&
                "The username must be between 3 and 25 characters.",
            !email.length && "Email is required!",
            !isEmail(email.length) && "Email is not valid!",
            !password.length && "Password is required!",
            (password.length < 3 || password.length > 25) &&
                "The password must be between 3 and 25 characters.",
        ].filter((x) => !!x);

        if (errors.length) {
            setMessage(errors.join(" "));
            setSuccessful(false);
        } else {
            setSuccessful(true);
        }
    };

    useEffect(() => {
        errorHandling();
    }, [username, email, password]);

    const handleRegister = async (e) => {
        e.preventDefault();

        errorHandling();

        if (successful) {
            AuthService.register(username, email, password).then(
                (response) => {
                    setMessage(response.data.message);
                    setSuccessful(true);
                },
                (error) => {
                    const resMessage =
                        (error.response &&
                            error.response.data &&
                            error.response.data.message) ||
                        error.message ||
                        error.toString();

                    setMessage(resMessage);
                    setSuccessful(false);
                }
            );
        }
    };

    return (
        <section className={classes.auth}>
            <h2>Register on StrmFindr</h2>
            <img
                src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
                alt="profile-img"
                className="profile-img-card"
            />
            <form onSubmit={handleRegister}>
                {!successful && (
                    <div>
                        <div className={classes.control}>
                            <label htmlFor="username">Username</label>
                            <input
                                type="text"
                                className="form-control"
                                name="username"
                                placeholder="Enter username"
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}
                                required
                            />
                        </div>

                        <div className={classes.control}>
                            <label htmlFor="email">Email</label>
                            <input
                                type="text"
                                className="form-control"
                                name="email"
                                placeholder="Enter email"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                required
                            />
                        </div>

                        <div className={classes.control}>
                            <label htmlFor="password">Password</label>
                            <input
                                type="password"
                                className="form-control"
                                name="password"
                                placeholder="Enter password"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                required
                            />
                        </div>

                        <div className={classes.actions}>
                            <button>Sign Up</button>
                        </div>
                    </div>
                )}
                {!!message && (
                    <div className="form-group">
                        <div
                            className={
                                successful
                                    ? "alert alert-success"
                                    : "alert alert-danger"
                            }
                            role="alert"
                        >
                            {message}
                        </div>
                    </div>
                )}
            </form>
        </section>
    );
};

export default Register;
