//
//  BottomNavItem.swift
//  iosApp
//
//  Created by user on 05.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

extension BottomNavItem {
    
    func toTitle() -> String {
        switch self.id {
            case BottomNavItem.main.id: return "Main"
            case BottomNavItem.menu.id: return "Menu"
            case BottomNavItem.contacts.id: return "Contacts"
            default: return "error"
        }
    }
        
    func toIcon() -> String {
        switch self.id {
            case BottomNavItem.main.id: return "Main"
            case BottomNavItem.menu.id: return "Menu"
            case BottomNavItem.contacts.id: return "Contacts"
            default: return "error"
        }
    }
}
