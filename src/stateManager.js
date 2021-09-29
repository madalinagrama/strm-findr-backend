import { atom } from "jotai";

import services from "./data/services.json";
import genres from "./data/genres.json";

const countries = Object.keys(services)
    .map((k) => services[k])
    .reduce((a, v) => a.concat(v), [])
    .sort()
    .filter((e, i, a) => !a.slice(0, i).includes(e))
    .map((c) => ({
        id: c,
        name: c.toUpperCase(),
    }));

const state = {
    currentCountryAtom: atom("ro"),
    currentKeywordAtom: atom(null),
    currentGenreAtom: atom(null),
    countriesListAtom: atom(countries),
    genresListAtom: atom(genres),
    servicesAtom: atom(services),
    loggedAtom: atom(false),
    cardsAtom: atom([
        {
            image: null,
            title: null,
            overview: null,
            id: null,
            service: "",
        },
    ]),
};

export default state;
