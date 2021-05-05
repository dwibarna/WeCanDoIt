package com.sobarna.sobarnamovies.viewmodel

import com.sobarna.sobarnamovies.R
import com.sobarna.sobarnamovies.model.SobanaMovies
import com.sobarna.sobarnamovies.model.SobanaShow

object DataMoviesAndShow {

    private val listShow = ArrayList<SobanaShow>()
    private val listNonMutableMovie = ArrayList<SobanaMovies>()

    fun getListShow():List<SobanaShow>{


        val resourceCreatorShow = arrayListOf(
                "Greg Berlanti,Marc Guggenheim and Andrew Kreisbergr",
                "Jeremy Carver",
                "Akira Toriyama",
                "Hiro Mashima",
                "Seth MacFarlane",
                "Greg Berlanti,Geoff Johns and Andrew Kreisberg",
                "D. B. Weiss and David Benioff",
                "Bruno Heller",
                "Shonda Rhimes",
                "David Farr",
                "Scott Buck",
                "Masashi Kishimoto",
                "Don McGill and Donald P. Bellisario",
                "Roberto Aguirre-Sacasa",
                "Paul Abbott and John Wells",
                "Greg Berlanti, Ali Adler and Andrew Kreisberg",
                "Eric Kripke",
                "Matt Groening",
                "Steve Blackman",
                "Frank Darabont"
        )

        val resourceOverview = arrayListOf(
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "Set in Springfield, the averager American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way."

        )
        val resourceGenreShow = arrayListOf(
                "Crime, Drama, Mystery, Action & Adventure",
                "Sci-Fi & Fantasy, Comedy, Drama",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
                "Animation, Comedy",
                "Drama, Sci-Fi & Fantasy",
                "Sci-Fi & Fantasy, Drama, Action & Adventure",
                "Drama, Crime, Sci-Fi & Fantasy",
                "Drama",
                "Action & Adventure, Drama",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "Crime, Action & Adventure, Drama",
                "Mystery, Drama, Crime",
                "Drama, Comedy",
                "Drama, Sci-Fi & Fantasy, Action & Adventure",
                "Drama, Mystery, Sci-Fi & Fantasy",
                "Family, Animation, Comedy",
                "Action & Adventure, Sci-Fi & Fantasy, Dram",
                "Action & Adventure, Drama, Sci-Fi & Fantasy"
        )

        val resourceTitleShow = arrayListOf(
                "Arrow",
                "Doom Patrol",
                "Dragon Ball",
                "Fairy Tail",
                "Family Guy",
                "The Flash",
                "Game of Thrones",
                "Gotham",
                "Grey's Anatomy",
                "Hanna",
                "Marvel's Iron Fist",
                "Naruto Shippuden",
                "NCIS",
                "Riverdale",
                "Shameless",
                "Supergirl",
                "Supernatural",
                "The Simpsons",
                "The Umbrella Academy",
                "The Walking Dead"
        )
        val resourceReleaseShow = arrayListOf(
                "October 10,2012",
                "February 15,2019",
                "February 26,1986",
                "October 12,2009",
                "January 31,1999",
                "October 7,2014",
                "April 17,2011",
                "September 22,2014",
                "March 27,2005",
                "March 28,2019",
                "March 17,2017",
                "February 15,2007",
                "September 23,2003",
                "January 26, 2017",
                "January 9,2011",
                "October 26,2015",
                "September 13,2005",
                "December 17, 1989",
                "February 15,2019",
                "October 31,2010"
        )
        val resourceShowAvatar = arrayListOf(
                R.drawable.poster_arrow,
                R.drawable.poster_doom_patrol,
                R.drawable.poster_dragon_ball,
                R.drawable.poster_fairytail,
                R.drawable.poster_family_guy,
                R.drawable.poster_flash,
                R.drawable.poster_god,
                R.drawable.poster_gotham,
                R.drawable.poster_grey_anatomy,
                R.drawable.poster_hanna,
                R.drawable.poster_iron_fist,
                R.drawable.poster_naruto_shipudden,
                R.drawable.poster_ncis,
                R.drawable.poster_riverdale,
                R.drawable.poster_shameless,
                R.drawable.poster_supergirl,
                R.drawable.poster_supernatural,
                R.drawable.poster_the_simpson,
                R.drawable.poster_the_umbrella,
                R.drawable.poster_the_walking_dead
        )
        for(position in resourceTitleShow.indices){
            val show = SobanaShow(
                    resourceShowAvatar[position],
                    resourceTitleShow[position],
                    resourceReleaseShow[position],
                    resourceGenreShow[position],
                    resourceOverview[position],
                    resourceCreatorShow[position]
            )
            listShow.add(show)
        }
        return listShow
    }

    fun getListMovie():ArrayList<SobanaMovies>{

        val resourceDirectorMovies = mutableListOf(
                "Bradley Cooper",
                "Robert Rodriguez",
                "James Wan",
                "Bryan Singer",
                "Hans Petter Moland",
                "Steven Caple Jr.",
                "David Yates",
                "M. Night Shyamalan",
                "Dean DeBlois",
                "Anthony Russo",
                "Josie Rourke",
                "Yuen Woo-Ping",
                "Christian Rivers",
                "Julius Avery",
                "Rich Moore",
                "Otto Bathurst",
                "Steven Knight",
                "Bob Persichetti",
                "Alexey Sidorov"
        )
        val resourceOverviewMovies = mutableListOf(
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles."
        )

        val resourceGenreMovie = mutableListOf(
                "Drama, Romance, Music",
                "Action, Science Fiction, Adventure",
                "Action, Adventure, Fantasy",
                "Music, Drama, History",
                "Action, Crime, Thriller",
                "Drama",
                "Adventure, Fantasy, Drama",
                "Thriller, Drama, Science Fiction",
                "Animation, Family, Adventure",
                "Adventure, Action, Science Fiction",
                "Drama, History",
                "Action",
                "Adventure, Science Fiction",
                "Horror, War, Science Fiction",
                "Family, Animation, Comedy, Adventure",
                "Adventure, Action, Thriller",
                "Thriller, Mystery, Drama",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "War, Action, Drama, History"
        )

        val resourceMovieAvatar = mutableListOf(
                R.drawable.poster_a_start_is_born,
                R.drawable.poster_alita,
                R.drawable.poster_aquaman,
                R.drawable.poster_bohemian,
                R.drawable.poster_cold_persuit,
                R.drawable.poster_creed,
                R.drawable.poster_crimes,
                R.drawable.poster_glass,
                R.drawable.poster_how_to_train,
                R.drawable.poster_infinity_war,
                R.drawable.poster_marry_queen,
                R.drawable.poster_master_z,
                R.drawable.poster_mortal_engines,
                R.drawable.poster_overlord,
                R.drawable.poster_ralph,
                R.drawable.poster_robin_hood,
                R.drawable.poster_serenity,
                R.drawable.poster_spiderman,
                R.drawable.poster_t34
        )
        val resourceTitleMovie = mutableListOf(
                "A Star Is Born",
                "Alita: Battle Angel",
                "Aquaman",
                "Bohemian Rhapsody",
                "Cold Pursuit",
                "Creed II",
                "Fantastic Beasts: The Crime of Grindelwald",
                "Glass",
                "How to Train Your Dragon : Hidden World",
                "Avengers: Infinity War",
                "Mary Queen of Scots",
                "Master Z: Ip Man Legacy",
                "Mortal Engines",
                "Overlord",
                "Ralph Breaks The Internet",
                "Robin Hood",
                "Serenity",
                "Spider-Man: Into the Spider-Verse",
                "T-34"
        )
        val resourceTime = mutableListOf(
                "October 3,2018",
                "January 31,2019",
                "December 7,2018",
                "October 24,2018",
                "February 7,2019",
                "November 21,2018",
                "November 14,2018",
                "January 16,2019",
                "January 3,2019",
                "April 25,2018",
                "December 7,2018",
                "20 December,2018",
                "November 27,2018",
                "November 1,2018",
                "November 20,2018",
                "November 21,2018",
                "January 24,2019",
                "December 6,2018",
                "December 27,2018")

        for(position in resourceTitleMovie.indices){
            val movie = SobanaMovies(
                    resourceMovieAvatar[position],
                    resourceTitleMovie[position],
                    resourceTime[position],
                    resourceGenreMovie[position],
                    resourceOverviewMovies[position],
                    resourceDirectorMovies[position]
            )


            listNonMutableMovie.add(movie)
        }
        return listNonMutableMovie
    }

}