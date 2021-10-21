import React from "react";
import ImageNotFound from "../img/ImageNotFound.png";
import { useAtom } from "jotai";
import state from "../stateManager";

import { AiOutlineHeart, AiFillHeart } from "react-icons/ai";

const Card = ({ image, title, overview, id, service, countries, imdb }) => {
    const picture = image || ImageNotFound;
    const [currentUser] = useAtom(state.currentUserAtom);
    const favoriteHandler = (id) => {
        if (currentUser) {
            console.log(currentUser, id);
        }
    };

    return (
        <div className="col-sm-12 col-md-6 col-lg-4 mb-4">
            <div className="bg-dark border card text-white">
                <img src={picture} className="card-img-top" alt={title} />
                <div className="card-body">
                    <h5 className="card-title">
                        <div className="title">{title}</div>
                        <button
                            className="btn btn-light"
                            onClick={(e) => favoriteHandler(id)}
                        >
                            <AiOutlineHeart className="fav" />
                        </button>
                    </h5>
                    <h6 className="card-subtitle mb-2 text-danger">
                        Available on {service.toUpperCase()} in {countries}
                    </h6>
                    <p className="card-text">{overview}</p>
                    <a
                        href={`https://www.imdb.com/title/${imdb}`}
                        className="btn btn-danger"
                    >
                        More details on IMDB
                    </a>
                </div>
            </div>
        </div>
    );
};

export default Card;
