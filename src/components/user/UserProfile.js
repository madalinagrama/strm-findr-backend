import React, {useEffect, useState} from "react";
import classes from "./UserProfile.module.css";
import clsx from "clsx";
import AuthService from "../auth/components/services/auth.service"
import * as userService from "./service/UserService";
import {
    Avatar,
    Box,
    Button,
    Card,
    CardActions,
    CardContent,
    Divider,
    Typography,
    makeStyles,
} from "@material-ui/core";
import PropTypes from "prop-types";

const useStyles = makeStyles(() => ({
    root: {},
    avatar: {
        height: 100,
        width: 100,
    },
}));

const UserProfile = ({ className, ...rest }) => {
    const [currentUser, setCurrentUser] = useState(AuthService.getCurrentUser());
    const [user, setUser] = useState({});
    const classes = useStyles();

    useEffect(() => {
        getUser();
        }, []);

    async function getUser() {
        return userService.getUser(currentUser.username).then((res) => {
            setUser(res.data)
        });
    }

    return (
        <Card className={clsx(classes.root, className)} {...rest}>
            <CardContent>
                <Box alignItems="center" display="flex" flexDirection="column">
                    <Avatar
                        className={classes.avatar}
                        src="https://cdn.forums.klei.com/monthly_2019_10/d2ab7d4323482214f463da3a5c12460944ccad0d_full.jpg.4d4cb95b2dbdd5dd9c6befca6e043515.jpg"
                    />
                    <Typography color="textPrimary" gutterBottom variant="h3">
                        {user.username}
                    </Typography>
                    <Typography color="textSecondary" variant="body1">
                        {user.email} {user.role}
                    </Typography>
                </Box>
            </CardContent>
        </Card>
    );
};

UserProfile.propTypes = {
    className: PropTypes.string,
};

export default UserProfile;
