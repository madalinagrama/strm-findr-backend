import React from "react";

import { VscGithubInverted } from "react-icons/vsc";

const About = () => {
    return (
        <div>
            <div className="row">
                <div className="col">
                    <p>
                        Ever wanted to see a movie but didn’t know which of the
                        many streaming platforms actually has it? Look no more!
                        STRM FINDR is the place for you!
                    </p>
                </div>
                <div className="row">
                    <div className="col">
                        <h3>Diana Gradinaru</h3>
                        <a href="https://github.com/DianaGradinaru">
                            <VscGithubInverted className="git" />
                        </a>
                    </div>
                </div>
                <div className="row">
                    <div className="col">
                        <h3>Diana Gradinaru</h3>
                        <a href="https://github.com/DianaGradinaru">
                            <VscGithubInverted className="git" />
                        </a>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default About;
