import {useAtom} from "jotai";
import {useState, useEffect} from "react";
import state from "../stateManager";
import {getUser} from "./user/service/UserService";
import profile from "../img/profile.jpg";

const UserProfile = () => {
    const profileProps = {
        src: profile,
        width: 120,
        height: 120,
    };

    const [currentUser, setCurrentUser] = useAtom(state.currentUserAtom);
    const [favorites, setFavorites] = useAtom(state.favoritesAtom);
    console.log(currentUser);
    const [user, setUser] = useState({
        username: null,
        role: null,
        email: null,
    });
    console.log(user);

    useEffect(() => {
        const setTheUser = async () => {
            return getUser(currentUser).then((res) => {
                setUser(res.data);
                setCurrentUser(res.data);
            });
        };

        setTheUser();
    }, []);

    return (
        <div className="card my-3">
            <div>
                <h5>Your Profile</h5>
            </div>
            <div>
                <img {...profileProps} alt={user.username}/>
            </div>
            <div className="card-body">
                    <h5 className="card-title">Name: {user.username}</h5>
                    <p className="card-text">Email: {user.email}</p>
                    //map ptr fiecare movieId
            </div>
        </div>

    );
};

export default UserProfile;
