# BottomNavScaffold

Android library for defining bottom navigation in jetpack compose reducing boilerplate

# Installation

Add in your build.gradle the
dependency `dev.davidvarela.bottomnavscaffold:bottomnavscafold:[compose_version]`,
where `compose_version` is the version of Compose your app depends on

# Usage

`BottomNavScaffold` wraps and replaces `androidx.compose.material.Scaffold` simplifying the
definition of a bottom bar navigation. To use it follow these two steps:

1. Declare your screens as a `list` of `BottomNavScreen`:

```
val screens = listOf(
        BottomNavScreen("films", R.string.films, R.drawable.films_icon, "films icon") { FilmsScreen(
            filmsViewModel = filmsViewModel
        ) },
        BottomNavScreen("games", R.string.games, R.drawable.games_icon, "games icon")  { FilmsScreen(
            filmsViewModel = filmsViewModel
        ) },
        BottomNavScreen("comics", R.string.comics, R.drawable.comics_icon, "comics icon")  { FilmsScreen(
            filmsViewModel = filmsViewModel
        ) }
    )
```

2. Invoke BottomNavScaffold:

```
BottomNavScaffold(rememberNavController(), screens)
```

if the start destination is the first screen of the list, or

```
BottomNavScaffold(rememberNavController(), screens, startDestination = "films")
```

otherwise

# Contributing

If you find a bug please open an issue or, even better, create a pull request with the fix

# Versioning

The versions of *BottomNavScaffold* use semantic versioning, matching the version of compose, so you
should use the same version of *BottomNavScaffold* as *Compose*

# Credits

Written by David González Varela

# License

Copyright 2021 David González Varela

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is
distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
implied. See the License for the specific language governing permissions and limitations under the
License.
