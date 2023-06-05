import SwiftUI
import shared

struct MainContentView: View {

    @StateObject var vm = ViewModel()

	var body: some View {
        TabView {
            ForEach(vm.tabs, id: \.id) { item in
    
                if item.id == BottomNavItem.main.id {
                    FlowerTypesScreen()
                        .tabItem {
                            Image(systemName: "Home")
                            Text("Home")
                        }
                } else if item.id == BottomNavItem.contacts.id {
                    ContactsScreen()
                        .tabItem {
                            Image(systemName: "Contacts")
                            Text("Contacts")
                        }
                } else if item.id == BottomNavItem.menu.id {
                    MenuScreen()
                        .tabItem {
                            Image(systemName: "Menu")
                            Text("Menu")
                        }
                } else {
                    Text("Unsupported tab for id")
                        .tabItem {
                            Image(systemName: "Menu")
                            Text("Unsupported")
                        }
                }
            }
        }
	}
}

extension MainContentView {
    
    @MainActor
    class ViewModel: ObservableObject {

        private let getBottomNavItemsUseCase = NavigationKoinModule().getBottomNavItemsUseCase
        
        @Published var tabs: [BottomNavItem] = []
        @Published var selection: Int = 0

        init() {
            Task {
                tabs = try await getBottomNavItemsUseCase.invoke()
            }
        }

    }
}

struct FlowerTypesScreen: View {
    var body: some View {
        Text("Flower Types")
    }
}

struct MenuScreen: View {
    var body: some View {
        Text("Menu")
    }
}

struct ContactsScreen: View {
    var body: some View {
        Text("Contacts")
    }
}
