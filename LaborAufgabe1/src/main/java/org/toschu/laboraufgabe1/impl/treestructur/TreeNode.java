/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.impl.treestructur;

import java.util.Objects;
import java.util.Vector;
import org.toschu.laboraufgabe1.framework.Concept;

/**
 *
 * @author toschu
 */
public class TreeNode {

    private int condition;
    private Vector<TreeNode> followers;
    private Concept concept;

    public TreeNode(int condition, Concept concept) {
        this.condition = condition;
        this.concept = concept;
    }

    public TreeNode(int condition, Vector<TreeNode> followers) {
        this.condition = condition;
        this.followers = followers;
    }

    public boolean addNewNode(TreeNode node) {
        if (!this.isConceptNode()) {
            if (this.followers == null) {
                this.followers = new Vector<>();
            }
            return this.followers.add(node);
        }
        return false;
    }

    public boolean isConceptNode() {
        return this.concept != null;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public Vector<TreeNode> getFollowers() {
        return followers;
    }

    public void setFollowers(Vector<TreeNode> followers) {
        this.followers = followers;
    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.condition;
        hash = 71 * hash + Objects.hashCode(this.followers);
        hash = 71 * hash + Objects.hashCode(this.concept);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TreeNode other = (TreeNode) obj;
        if (this.condition != other.condition) {
            return false;
        }
        if (!Objects.equals(this.followers, other.followers)) {
            return false;
        }
        if (this.concept != other.concept) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TreeNode{"
                + "condition=" + condition
                + ", followers=" + followers
                + ", concept=" + concept + '}';
    }

}
