import React, { useState } from "react";

import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";

import AuthService from "./services/auth.service";
import isEmail from "validator/es/lib/isEmail";

import classes from "./AuthForm.module.css";

const Register = () => {
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [message, setMessage] = useState("");
    const [successful, setSuccessful] = useState(false);

    const validations = {
        required: (value) => {
            if (!value) {
                setMessage("This field is required!");
            }
        },
        email: (value) => {
            if (!isEmail(value)) {
                setMessage("This is not a valid email.");
            }
        },
        vusername: (value) => {
            if (value.length < 3 || value.length > 25) {
                setMessage("The username must be between 3 and 25 characters.");
            }
        },
        vpassword: (value) => {
            if (value.length < 3 || value.length > 25) {
                setMessage("The password must be between 3 and 25 characters.");
            }
        },
    };

    const handleRegister = async (e) => {
        e.preventDefault();

        setMessage("");
        setSuccessful(true);

        this.form.validateAll();

        if (this.checkBtn.context._errors.length === 0) {
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
            <Form
                onSubmit={handleRegister}
                ref={(c) => {
                    this.form = c;
                }}
            >
                {!successful && (
                    <div>
                        <div className={classes.control}>
                            <label htmlFor="username">Username</label>
                            <Input
                                type="text"
                                className="form-control"
                                name="username"
                                placeholder="Enter username"
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}
                                validations={[
                                    validations.required,
                                    validations.vusername,
                                ]}
                            />
                        </div>

                        <div className={classes.control}>
                            <label htmlFor="email">Email</label>
                            <Input
                                type="text"
                                className="form-control"
                                name="email"
                                placeholder="Enter email"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                validations={[
                                    validations.required,
                                    validations.email,
                                ]}
                            />
                        </div>

                        <div className={classes.control}>
                            <label htmlFor="password">Password</label>
                            <Input
                                type="password"
                                className="form-control"
                                name="password"
                                placeholder="Enter password"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                validations={[
                                    validations.required,
                                    validations.vpassword,
                                ]}
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
                <CheckButton
                    style={{ display: "none" }}
                    ref={(c) => {
                        this.checkBtn = c;
                    }}
                />
            </Form>
        </section>
    );
};

export default Register;
