package com.sobarna.sobarnamovies.utils

import com.sobarna.sobarnamovies.model.MovieResponse
import com.sobarna.sobarnamovies.model.Result
import com.sobarna.sobarnamovies.model.ResultX
import com.sobarna.sobarnamovies.model.ShowResponse

object DataMoviesAndShow {

    fun getShowsData():ArrayList<ResultX>{
        val shows = ArrayList<ResultX>()


        shows.add(
            ResultX(
                "2021-03-19",
                88396,
                "The Falcon and the Winter Soldier",
                "en",
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                2008.626,
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
                5264))


        shows.add(
            ResultX(
                "2021-03-26",
                95557,
                "Invincible",
                "en",
                "Invincible",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                1967.083,
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                8.9,
                1237))

        shows.add(
            ResultX(
                "2017-09-25",
                71712,
                "The Good Doctor",
                "en",
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                1303.627,
                "/53P8oHo9cfOsgb1cLxBi4pFY0ja.jpg",
                8.6,
                8256))


        shows.add(
            ResultX(
                "2014-10-07",
                60735,
                "The Flash",
                "en",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                1278.584,
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                7.7,
                7512))



        shows.add(
            ResultX(
                "2018-04-22",
                79008,
                "Luis Miguel: The Series",
                "es",
                "Luis Miguel: La Serie",
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                1003.741,
                "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                8.1,
                364))


        shows.add(
            ResultX(
                "2005-03-27",
                1416,
                "Grey's Anatomy",
                "en",
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                906.4,
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                8.2,
                5971))


        shows.add(
            ResultX(
                "2021-03-31",
                120587,
                "Haunted: Latin America",
                "es",
                "Haunted: Latinoamérica",
                "Real people's terrifying tales of the chilling, unexplained and paranormal come to life with dramatic reenactments in this reality series.",
                775.355,
                "/Q1ZYG3kDS8iVIHOYOJ9NQmV0q7.jpg",
                7.5,
                201))


        shows.add(
            ResultX(
                "2016-01-25",
                63174,
                "Lucifer",
                "en",
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                779.561,
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                8.5,
                8448))

        shows.add(
            ResultX(
                "2017-01-26",
                69050,
                "Riverdale",
                "en",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                758.299,
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                8.6,
                11159))
        shows.add(
            ResultX("2016-09-23",
            65820,
        "Van Helsing",
         "en",
        "Van Helsing",
        "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
        707.051,
         "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
         6.9,
        533))


        shows.add(
            ResultX("2011-04-17",
             1399,
        "Game of Thrones",
        "en",
         "Game of Thrones",
        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
        577.112,
         "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
         8.4,
        14222))


        shows.add(
            ResultX( "2010-10-31",
            1402,
        "The Walking Dead",
        "en",
        "The Walking Dead",
         "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
        539.78,
         "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
         8.1,
        10706))



        shows.add(
            ResultX( "2015-08-23",
            62286,
         "Fear the Walking Dead",
        "en",
         "Fear the Walking Dead",
        "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
        533.488,
         "/4UjiPdFKJGJYdxwRs2Rzg7EmWqr.jpg",
         7.6,
        3461))



        shows.add(
            ResultX("2021-01-15",
             85271,
       "WandaVision",
         "en",
         "WandaVision",
        "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
       489.16,
        "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
        8.4,
         8357))



        shows.add(
            ResultX(
                 "2021-03-24",
             120168,
         "Who Killed Sara?",
         "es",
         "¿Quién mató a Sara?",
         "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
         478.617,
        "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
         7.8,
         458))


        shows.add(
            ResultX(
                 "2021-02-23",
             95057,
        "Superman & Lois",
         "en",
        "Superman & Lois",
       "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
         447.791,
         "/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
         8.3,
         785))


        shows.add(
            ResultX( "2018-10-25",
            79460,
        "Legacies",
        "en",
         "Legacies",
         "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
         399.246,
        "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
         8.6,
        1831
        ))


        shows.add(
            ResultX( "2009-09-10",
                18165,
        "The Vampire Diaries",
         "en",
         "The Vampire Diaries",
        "The story of two vampire brothers obsessed with the same girl, who bears a striking resemblance to the beautiful but ruthless vampire they knew and loved in 1864.",
        398.567,
         "/kLEha9zVVv8acGFKTX4gjvSR2Q0.jpg",
         8.3,
        5788))


        shows.add(
            ResultX("2018-06-12",
            80240,
        "The Queen of Flow",
        "es",
         "La Reina del Flow",
        "After spending seventeen years in prison unfairly, a talented songwriter seeks revenge on the men who sank her and killed her family.",
         346.663,
        "/3T5mSuziI0TMa7z9R5w3vNl2qok.jpg",
         7.9,
         695))


        shows.add(
            ResultX("2018-05-02",
                77169,
                "Cobra Kai",
                "en",
        "Cobra Kai",
        "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
        361.438,
         "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
         8.1,
        3032))

        return shows

    }


/*

    fun getMoviesData():ArrayList<Result>{


        val movies = ArrayList<Result>()

        movies.add(Result(460465,
                        "en",
                        "Mortal Kombat",
                        "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                        6382.461,
                        "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                        "2021-04-07",
                        "Mortal Kombat",
                        7.8,
                        2004))

        movies.add(
            Result(399566,
                "en",
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                3280.437,
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "2021-03-24",
                "Godzilla vs. Kong",
                8.2,
                5218))
        movies.add(
            Result(804435,
                "en",
                "Vanquish",
                 "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                3144.735,
                "/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                 "2021-04-16",
                "Vanquish",
                 6.1,
                 47))
                movies.add(Result(635302,
                "ja",
                "劇場版「鬼滅の刃」無限列車編",
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                 2299.982,
                "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                 "2020-10-16",
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                 8.3,
                790))

                movies.add(Result(632357,
                "en",
                "The Unholy",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                2054.733,
                 "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                "2021-03-31",
                "The Unholy",
                 5.7,
                66))

                movies.add(Result(
                         412656,
                         "en",
               "Chaos Walking",
                "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                 1538.733,
                 "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                 "2021-02-24",
                "Chaos Walking",
                 7.3,
                509

                ))
                movies.add(Result(
                        587807,
                         "en",
                "Tom & Jerry",
                 "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
                 941.781,
                "/yMoMlJo2msoVwmuf6k1C78MrB3H.jpg",
                "2021-02-11",
                "Tom & Jerry",
                7.3,
                1286
                ))

                movies.add(Result(
                        581387,
                         "ko",
                 "백두산",
                 "A group of unlikely heroes from across the Korean peninsula try to save the day after a volcano erupts on the mythical and majestic Baekdu Mountain.",
                751.921,
                 "/zoeKREZ2IdAUnXISYCS0E6H5BVh.jpg",
                 "2019-12-19",
                 "Ashfall",
                 6.6,
                237
                ))

                movies.add(Result(
                         660943,
                         "es",
                "El olvido que seremos",
                "Portrays the life of Héctor Abad Gómez, a prominent doctor and human rights activist in the polarized, violent Medellin of the 70s. A family man worried not only for his own children but those of the underprivileged classes as well, his home was imbued with vitality and creativity, the result of an education based on tolerance and love. Nothing could foretell that a terrible cancer would take the life of one of his beloved daughters. Driven by sadness and rage, Héctor devoted himself to the social and political causes of the time. But Medellin's intolerant society would harass him until he was finally silenced.",
                 475.848,
                 "/cKCVRr3Hvy4MoV2R0tvS31C9wql.jpg",
                 "2020-08-22",
                "Forgotten We’ll Be",
                 6.7,
                 5
                ))

                movies.add(Result(
                        556867,
                 "en",
                "Breaking News in Yuba County",
                "An overlooked pencil-pusher catches her husband in bed with another woman, the shock of which causes him to die of a heart attack. So she buries his body and takes advantage of the growing celebrity status that comes from having a missing husband. But she quickly finds herself in over her head, dodging cops and criminals, all while trying to keep the truth from her sister, a local news anchor who’s desperate for a story.",
                 374.741,
                "/pMyCYtgfBmMisX3RFc5eH6zIV5Y.jpg",
                 "2021-05-20",
                "Breaking News in Yuba County",
                        0.0,
                        0
                ))


                movies.add(Result(
                        581734,
                 "en",
                 "Nomadland",
                 "A woman in her sixties embarks on a journey through the western United States after losing everything in the Great Recession, living as a van-dwelling modern-day nomad.",
                 368.018,
                "/66GUmWpTHgAjyp4aBSXy63PZTiC.jpg",
                "2021-01-29",
                "Nomadland",
                 7.4,
                824
                ))

                movies.add(Result(
                520946,
                "en",
                "100% Wolf",
                "Freddy Lupin, heir to a proud family line of werewolves, is in for a shock when on his 14th birthday his first 'warfing' goes awry, turning him into a ferocious poodle. The pack elders give Freddy until the next moonrise to prove he has the heart of a wolf, or risk being cast out forever. With the help of an unlikely ally in a streetwise stray named Batty, Freddy must prove he's 100% Wolf.",
                323.859,
             "/2VrvxK4yxNCU6KVgo5TADJeBEQu.jpg",
              "2020-06-26",
              "100% Wolf",

              5.7,
             145
                ))


                movies.add(Result(
              560192,
               "en",
                 "Grand Isle",
             "Walter and his neglected wife lure a young man into their Victorian home to escape a hurricane. When the man is charged with murder by Det. Jones, he must reveal the couple's wicked secrets to save himself.",
                214.892,
            "/8mcXb3km7hZ8aJKpxxgnvvxt9gW.jpg",
            "2019-12-06",
               "Grand Isle",

                 6.0,
                 160
                ))

                movies.add(Result(
                520763,
                 "en",
                 "A Quiet Place Part II",
                "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.",
                 180.234,
                "/4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg",
                "2021-05-27",
              "A Quiet Place Part II",

           0.0,
              0
                ))


                movies.add(Result(

                 741228,
                 "en",
                "Locked Down",
                "During a COVID-19 lockdown, sparring couple Linda and Paxton call a truce to attempt a high-risk jewellery heist at one of the world's most exclusive department stores, Harrods.",
                 176.62,
                "/svHelD0Hb3TXPAQoPsoBwdDMTvf.jpg",
                "2021-02-25",
                "Locked Down",
               5.5,
             50
                ))

        movies.add(
            Result(
                385128,
                "en",
                "F9",
                "Dominic Toretto is leading a quiet life off the grid with Letty and his son, little Brian, but they know that danger always lurks just over their peaceful horizon. This time, that threat will force Dom to confront the sins of his past if he’s going to save those he loves most. His crew joins together to stop a world-shattering plot led by the most skilled assassin and high-performance driver they’ve ever encountered: a man who also happens to be Dom’s forsaken brother, Jakob.",
                175.835,
                "/bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
                "2021-05-19",
                "F9",
                0.0,
                0
            )
        )

        movies.add(
            Result(
                647302,
                "en",
                "Benny Loves You",
                "Jack, a man desperate to improve his life throws away his beloved childhood plush, Benny. It’s a move that has disastrous consequences when Benny springs to life with deadly intentions!",
                171.48,
                "/mQ8vALvqA0z0qglG3gI6xpVcslo.jpg",
                "2021-05-07",
                "Benny Loves You",
                7.0,
                3
            )
        )



        movies.add(
            Result(
                600354,
                "en",
                "The Father",
                "A man refuses all assistance from his daughter as he ages and, as he tries to make sense of his changing circumstances, he begins to doubt his loved ones, his own mind and even the fabric of his reality.",
                148.298,
                "/uxWXW1YYQENSv7OzHB4Hds0bK3b.jpg",
                "2020-12-23",
                "The Father",
                8.3,
                585
            )
        )




        movies.add(
            Result(
                337404,
                "en",
                "Cruella",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                139.529,
                "/hjS9mH8KvRiGHgjk6VUZH7OT0Ng.jpg",
                "2021-05-26",
                "Cruella",

                0.0,
                0
            )
        )


        movies.add(
            Result(
                486589,
                "en",
                "Red Shoes And The Seven Dwarfs",
                "Princes who have been turned into Dwarfs seek the red shoes of a lady in order to break the spell, although it will not be easy.",
                119.895,
                "/MBiKqTsouYqAACLYNDadsjhhC0.jpg",
                "2019-07-25",
                "Red Shoes And The Seven Dwarfs",
                7.6,
                660
            )
        )


                return movies
        }

    fun getMoviesDataDummy():ArrayList<MovieResponse>{
        val movies = ArrayList<MovieResponse>()

        movies.add(MovieResponse(460465,
            "en",
            "Mortal Kombat",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            6382.461,
            "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
            "2021-04-07",
            "Mortal Kombat",
            7.8,
            2004))

        movies.add(
            MovieResponse(399566,
                "en",
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                3280.437,
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "2021-03-24",
                "Godzilla vs. Kong",
                8.2,
                5218))
        movies.add(
            MovieResponse(804435,
                "en",
                "Vanquish",
                "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                3144.735,
                "/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                "2021-04-16",
                "Vanquish",
                6.1,
                47))
        movies.add(MovieResponse(635302,
            "ja",
            "劇場版「鬼滅の刃」無限列車編",
            "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
            2299.982,
            "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
            "2020-10-16",
            "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
            8.3,
            790))

        movies.add(MovieResponse(632357,
            "en",
            "The Unholy",
            "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
            2054.733,
            "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
            "2021-03-31",
            "The Unholy",
            5.7,
            66))

        movies.add(MovieResponse(
            412656,
            "en",
            "Chaos Walking",
            "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
            1538.733,
            "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
            "2021-02-24",
            "Chaos Walking",
            7.3,
            509

        ))
        movies.add(MovieResponse(
            587807,
            "en",
            "Tom & Jerry",
            "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
            941.781,
            "/yMoMlJo2msoVwmuf6k1C78MrB3H.jpg",
            "2021-02-11",
            "Tom & Jerry",
            7.3,
            1286
        ))

        movies.add(MovieResponse(
            581387,
            "ko",
            "백두산",
            "A group of unlikely heroes from across the Korean peninsula try to save the day after a volcano erupts on the mythical and majestic Baekdu Mountain.",
            751.921,
            "/zoeKREZ2IdAUnXISYCS0E6H5BVh.jpg",
            "2019-12-19",
            "Ashfall",
            6.6,
            237
        ))

        movies.add(MovieResponse(
            660943,
            "es",
            "El olvido que seremos",
            "Portrays the life of Héctor Abad Gómez, a prominent doctor and human rights activist in the polarized, violent Medellin of the 70s. A family man worried not only for his own children but those of the underprivileged classes as well, his home was imbued with vitality and creativity, the result of an education based on tolerance and love. Nothing could foretell that a terrible cancer would take the life of one of his beloved daughters. Driven by sadness and rage, Héctor devoted himself to the social and political causes of the time. But Medellin's intolerant society would harass him until he was finally silenced.",
            475.848,
            "/cKCVRr3Hvy4MoV2R0tvS31C9wql.jpg",
            "2020-08-22",
            "Forgotten We’ll Be",
            6.7,
            5
        ))

        movies.add(MovieResponse(
            556867,
            "en",
            "Breaking News in Yuba County",
            "An overlooked pencil-pusher catches her husband in bed with another woman, the shock of which causes him to die of a heart attack. So she buries his body and takes advantage of the growing celebrity status that comes from having a missing husband. But she quickly finds herself in over her head, dodging cops and criminals, all while trying to keep the truth from her sister, a local news anchor who’s desperate for a story.",
            374.741,
            "/pMyCYtgfBmMisX3RFc5eH6zIV5Y.jpg",
            "2021-05-20",
            "Breaking News in Yuba County",
            0.0,
            0
        ))


        movies.add(MovieResponse(
            581734,
            "en",
            "Nomadland",
            "A woman in her sixties embarks on a journey through the western United States after losing everything in the Great Recession, living as a van-dwelling modern-day nomad.",
            368.018,
            "/66GUmWpTHgAjyp4aBSXy63PZTiC.jpg",
            "2021-01-29",
            "Nomadland",
            7.4,
            824
        ))

        movies.add(MovieResponse(
            520946,
            "en",
            "100% Wolf",
            "Freddy Lupin, heir to a proud family line of werewolves, is in for a shock when on his 14th birthday his first 'warfing' goes awry, turning him into a ferocious poodle. The pack elders give Freddy until the next moonrise to prove he has the heart of a wolf, or risk being cast out forever. With the help of an unlikely ally in a streetwise stray named Batty, Freddy must prove he's 100% Wolf.",
            323.859,
            "/2VrvxK4yxNCU6KVgo5TADJeBEQu.jpg",
            "2020-06-26",
            "100% Wolf",

            5.7,
            145
        ))


        movies.add(MovieResponse(
            560192,
            "en",
            "Grand Isle",
            "Walter and his neglected wife lure a young man into their Victorian home to escape a hurricane. When the man is charged with murder by Det. Jones, he must reveal the couple's wicked secrets to save himself.",
            214.892,
            "/8mcXb3km7hZ8aJKpxxgnvvxt9gW.jpg",
            "2019-12-06",
            "Grand Isle",

            6.0,
            160
        ))

        movies.add(MovieResponse(
            520763,
            "en",
            "A Quiet Place Part II",
            "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.",
            180.234,
            "/4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg",
            "2021-05-27",
            "A Quiet Place Part II",

            0.0,
            0
        ))


        movies.add(
            MovieResponse(

            741228,
            "en",
            "Locked Down",
            "During a COVID-19 lockdown, sparring couple Linda and Paxton call a truce to attempt a high-risk jewellery heist at one of the world's most exclusive department stores, Harrods.",
            176.62,
            "/svHelD0Hb3TXPAQoPsoBwdDMTvf.jpg",
            "2021-02-25",
            "Locked Down",
            5.5,
            50
        )
        )


        movies.add(
            MovieResponse(
        385128,
         "en",
         "F9",
         "Dominic Toretto is leading a quiet life off the grid with Letty and his son, little Brian, but they know that danger always lurks just over their peaceful horizon. This time, that threat will force Dom to confront the sins of his past if he’s going to save those he loves most. His crew joins together to stop a world-shattering plot led by the most skilled assassin and high-performance driver they’ve ever encountered: a man who also happens to be Dom’s forsaken brother, Jakob.",
         175.835,
         "/bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
        "2021-05-19",
         "F9",
         0.0,
         0
            )
        )

        movies.add(
            MovieResponse(
         647302,
         "en",
         "Benny Loves You",
         "Jack, a man desperate to improve his life throws away his beloved childhood plush, Benny. It’s a move that has disastrous consequences when Benny springs to life with deadly intentions!",
         171.48,
         "/mQ8vALvqA0z0qglG3gI6xpVcslo.jpg",
         "2021-05-07",
        "Benny Loves You",
         7.0,
         3
            )
        )



        movies.add(
            MovieResponse(
                600354,
                "en",
                "The Father",
                "A man refuses all assistance from his daughter as he ages and, as he tries to make sense of his changing circumstances, he begins to doubt his loved ones, his own mind and even the fabric of his reality.",
                148.298,
                "/uxWXW1YYQENSv7OzHB4Hds0bK3b.jpg",
            "2020-12-23",
            "The Father",
            8.3,
            585
            )
        )




        movies.add(
            MovieResponse(
        337404,
         "en",
         "Cruella",
         "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
        139.529,
        "/hjS9mH8KvRiGHgjk6VUZH7OT0Ng.jpg",
        "2021-05-26",
        "Cruella",

         0.0,
         0
            )
        )


        movies.add(
            MovieResponse(
                486589,
                "en",
        "Red Shoes And The Seven Dwarfs",
        "Princes who have been turned into Dwarfs seek the red shoes of a lady in order to break the spell, although it will not be easy.",
         119.895,
         "/MBiKqTsouYqAACLYNDadsjhhC0.jpg",
         "2019-07-25",
        "Red Shoes And The Seven Dwarfs",
         7.6,
        660
            )
        )

        return movies
    }


    fun getShowsDataDummy():ArrayList<ShowResponse>{
        val shows = ArrayList<ShowResponse>()

        shows.add(
            ShowResponse("2021-03-19",
                88396,
                "The Falcon and the Winter Soldier",
                "en",
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                2008.626,
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
                5264))


        shows.add(
            ShowResponse("2021-03-26",
                95557,
                "Invincible",
                "en",
                "Invincible",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                1967.083,
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                8.9,
                1237))

        shows.add(
            ShowResponse("2017-09-25",
                71712,
                "The Good Doctor",
                "en",
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                1303.627,
                "/53P8oHo9cfOsgb1cLxBi4pFY0ja.jpg",
                8.6,
                8256))


        shows.add(
            ShowResponse("2014-10-07",
                60735,
                "The Flash",
                "en",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                1278.584,
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                7.7,
                7512))



        shows.add(
            ShowResponse("2018-04-22",
                79008,
                "Luis Miguel: The Series",
                "es",
                "Luis Miguel: La Serie",
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                1003.741,
                "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                8.1,
                364))


        shows.add(
            ShowResponse("2005-03-27",
                1416,
                "Grey's Anatomy",
                "en",
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                906.4,
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                8.2,
                5971))


        shows.add(
            ShowResponse("2021-03-31",
                120587,
                "Haunted: Latin America",
                "es",
                "Haunted: Latinoamérica",
                "Real people's terrifying tales of the chilling, unexplained and paranormal come to life with dramatic reenactments in this reality series.",
                775.355,
                "/Q1ZYG3kDS8iVIHOYOJ9NQmV0q7.jpg",
                7.5,
                201))


        shows.add(
            ShowResponse( "2016-01-25",
                63174,
                "Lucifer",
                "en",
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                779.561,
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                8.5,
                8448))

        shows.add(
            ShowResponse("2017-01-26",
                69050,
                "Riverdale",
                "en",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                758.299,
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                8.6,
                11159))


        shows.add(
            ShowResponse("2016-09-23",
                65820,
                "Van Helsing",
                "en",
                "Van Helsing",
                "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
                707.051,
                "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
                6.9,
                533))


        shows.add(
            ShowResponse("2011-04-17",
                1399,
                "Game of Thrones",
                "en",
                "Game of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                577.112,
                "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                8.4,
                14222))


        shows.add(
            ShowResponse( "2010-10-31",
                1402,
                "The Walking Dead",
                "en",
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                539.78,
                "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                8.1,
                10706))



        shows.add(
            ShowResponse( "2015-08-23",
                62286,
                "Fear the Walking Dead",
                "en",
                "Fear the Walking Dead",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                533.488,
                "/4UjiPdFKJGJYdxwRs2Rzg7EmWqr.jpg",
                7.6,
                3461))



        shows.add(
            ShowResponse("2021-01-15",
                85271,
                "WandaVision",
                "en",
                "WandaVision",
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                489.16,
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                8.4,
                8357))



        shows.add(
            ShowResponse(
                "2021-03-24",
                120168,
                "Who Killed Sara?",
                "es",
                "¿Quién mató a Sara?",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                478.617,
                "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                7.8,
                458))


        shows.add(
            ShowResponse(
                "2021-02-23",
                95057,
                "Superman & Lois",
                "en",
                "Superman & Lois",
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                447.791,
                "/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                8.3,
                785))


        shows.add(
            ShowResponse( "2018-10-25",
                79460,
                "Legacies",
                "en",
                "Legacies",
                "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
                399.246,
                "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
                8.6,
                1831
            ))


        shows.add(
            ShowResponse( "2009-09-10",
                18165,
                "The Vampire Diaries",
                "en",
                "The Vampire Diaries",
                "The story of two vampire brothers obsessed with the same girl, who bears a striking resemblance to the beautiful but ruthless vampire they knew and loved in 1864.",
                398.567,
                "/kLEha9zVVv8acGFKTX4gjvSR2Q0.jpg",
                8.3,
                5788))


        shows.add(
            ShowResponse("2018-06-12",
                80240,
                "The Queen of Flow",
                "es",
                "La Reina del Flow",
                "After spending seventeen years in prison unfairly, a talented songwriter seeks revenge on the men who sank her and killed her family.",
                346.663,
                "/3T5mSuziI0TMa7z9R5w3vNl2qok.jpg",
                7.9,
                695))


        shows.add(
            ShowResponse("2018-05-02",
                77169,
                "Cobra Kai",
                "en",
                "Cobra Kai",
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                361.438,
                "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                8.1,
                3032))

        return shows

    }




 */

}