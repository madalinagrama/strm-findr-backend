import { atom } from "jotai";

// import services from "./data/services.json";
import genres from "./data/genres.json";

const countries = [
    "ae",
    "ar",
    "at",
    "au",
    "az",
    "be",
    "bg",
    "br",
    "ca",
    "ch",
    "cl",
    "co",
    "cy",
    "cz",
    "de",
    "dk",
    "ec",
    "ee",
    "es",
    "fi",
    "fr",
    "gb",
    "gr",
    "hk",
    "hu",
    "id",
    "ie",
    "il",
    "in",
    "is",
    "it",
    "jp",
    "kr",
    "lt",
    "lv",
    "md",
    "mk",
    "mx",
    "my",
    "nl",
    "no",
    "nz",
    "pa",
    "pe",
    "ph",
    "pl",
    "pt",
    "ro",
    "rs",
    "ru",
    "se",
    "sg",
    "th",
    "tn",
    "tr",
    "ua",
    "us",
    "ve",
    "vn",
    "za",
];

const services = [
    "apple",
    "disney",
    "hbo",
    "hulu",
    "mubi",
    "netflix",
    "paramount",
    "peacock",
    "prime",
    "showtime",
    "starz",
];

const state = {
    currentCountryAtom: atom("ro"),
    currentKeywordAtom: atom(null),
    currentGenreAtom: atom(null),
    countriesListAtom: atom(countries),
    genresListAtom: atom(genres),
    servicesAtom: atom(services),
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
