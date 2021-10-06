import React, { useEffect, useState } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { useAtom } from "jotai";
import axios from "axios";
import state from "./stateManager";

import Header from "./components/Header";
import Index from "./components/Index";
import Country from "./components/Country";
import Genre from "./components/Genre";
import About from "./components/About";
import AuthPage from "./pages/AuthPage";
import ProfilePage from "./pages/ProfilePage";
import Spinner from "./components/Spinner";

import "./App.css";

const App = () => {
    const [country] = useAtom(state.currentCountryAtom);
    const [keyword] = useAtom(state.currentKeywordAtom);
    const [genre] = useAtom(state.currentGenreAtom);
    const [services] = useAtom(state.servicesAtom);
    const [_cards, setCards] = useAtom(state.cardsAtom);

    const [loading, setLoading] = useAtom(state.loadingAtom);

    const [movies, setMovies] = useState([]);

    useEffect(() => {
        const cardsLoader = async () => {
            let cards = [];

            axios
                .get(process.env.REACT_APP_URL)
                .then((data) => {
                    data.data.forEach((r) => {
                        cards.push({
                            image: r.posterURL,
                            title: r.originalTitle,
                            overview: r.overview.slice(0, 150) + "...",
                            id: r.imdbID,
                            service: r.streamingInfo,
                        });
                    });

                    if (cards.length) {
                        setCards(cards);
                        setLoading(false);
                    }
                })
                .catch((e) => {
                    console.error(e);
                });
        };

        cardsLoader();
    }, []);

    return (
        <Router>
            <Header />
            {loading && <Spinner />}
            {!loading && (
                <div className="container mt-3">
                    <Switch>
                        <Route path="/country/:country">
                            <Country />
                        </Route>
                        <Route path="/genre/:genre">
                            <Genre />
                        </Route>
                        <Route path="/about">
                            <About />
                        </Route>

                        <Route exact path="/login">
                            <AuthPage />
                        </Route>

                        <Route exact path="/profile">
                            <ProfilePage />
                        </Route>

                        <Route exact path="/">
                            <Index />
                        </Route>
                    </Switch>
                </div>
            )}
        </Router>
    );
};

export default App;
